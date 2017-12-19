package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {

	//initializing Minimum to max value.
	static int Minimum = Integer.MAX_VALUE;
	//function to determine if the current minimum is lower than the new minimum
     public void areYouUpTodate (int resultsMaybe) {
        if(resultsMaybe < Minimum) {
                Minimum = resultsMaybe;
        } else {
        //do nothing 
        }
    }    

    //setting up all the threads for minimumPairwiseDistance
	@Override
    public int minimumPairwiseDistance(int[] values) {
       // throw new UnsupportedOperationException();
    Thread LL = new Thread(new LL(values));
	Thread BR = new Thread(new LL(values));
	Thread TR = new Thread(new LL(values));
	Thread C = new Thread(new LL(values));
	//Starting all of the previous threads
	LL.start();
	BR.start();
	TR.start();
	C.start();
	try{ 
		//joining all of the previous threads. 
		LL.join();
		BR.join();
		TR.join();
		C.join();

		//yay possible system error
	} catch (InterruptedException YAY) {
		System.out.println(YAY);
	}
	//Return the final answer that is Minimum
	return Minimum;		
    }

    //The next part of the comments will apply to all four of the repeated thread calcualtions
    //
    //Create class for each thread
    //
	class LL implements Runnable {
	       //create variable to store the newly found possible minimum
	       int am_I_The_New_Minimum;
	       int[] values;


	LL(int minimum, int[] values) {
		this.values = values;
		am_I_The_New_Minimum = minimum;
	}	
	//Thread then runs the following nest for loops, looping over its area to find the minimum value of
	//that area
	//then checks the current global min to the found min, if the found min is lower it updates the global
	//the area checked by the for loop changes for each thread.
	public void run() {
		int new_result_maybe = Integer.MAX_VALUE;
		for (int i = 0; i < values. length/2; i++) {
    			for (int j = 0; j < i; j++) {
				int difference = Math.abs(values[i] - values[j]);
		    		if (difference < new_result_maybe) {
			    		new_result_maybe = difference;
				    }
		}

	}
	areYouUpTodate(new_result_maybe);

    }
}
	class BR implements Runnable {
               int am_I_The_New_Minimum;
               int[] values;
        BR(int minimum, int[] values) { 
                this.values = values;
                am_I_The_New_Minimum = minimum;
        }
        public void run() {
                int new_result_maybe = Integer.MAX_VALUE;
                for (int i = values.length/2; i < values. length; i++) {                
                        for (int j = 0; j < i - values.length/2; j++) {
                                int difference = Math.abs(values[i] - values[j]);
                                if (difference < new_result_maybe) {
                                        new_result_maybe = difference;
                                    }
                }
                
        }
        areYouUpTodate(new_result_maybe);
    }

}
	class TR implements Runnable {
               int am_I_The_New_Minimum;
               int[] values;

        TR(int minimum, int[] values) { 
                this.values = values;
                am_I_The_New_Minimum = minimum;
        }

        public void run() {
                int new_result_maybe = Integer.MAX_VALUE;
                for (int i = values.length/2; i < values. length; i++) {                
                        for (int j = values.length/2; j < i; j++) {
                                int difference = Math.abs(values[i] - values[j]);
                                if (difference < new_result_maybe) {
                                        new_result_maybe = difference;
                                    }
                }
                
        }
        areYouUpTodate(new_result_maybe);

    }

}

	class C implements Runnable {
               int am_I_The_New_Minimum;
               int[] values;

        C(int minimum, int[] values) { 
                this.values = values;
                am_I_The_New_Minimum = minimum;
        }

        public void run() {
                int new_result_maybe = Integer.MAX_VALUE;
                for (int i = 0; i < values. length/2; i++) {                
                        for (int j = 0; j < i + values.length/2; j++) {
                                int difference = Math.abs(values[j] - values[i]);
                                if (difference < new_result_maybe) {
                                        new_result_maybe = difference;
                                    }
                }
                
        }
        areYouUpTodate(new_result_maybe);

    }

}



}

