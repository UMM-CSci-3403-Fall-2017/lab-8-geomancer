package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {

	//initializing Minimum to max value.
	public int Minimum = Integer.MAX_VALUE;
	//function to determine if the current minimum is lower than the new minimum
     public void updateGlobalResult (int resultsMaybe) {
        if(resultsMaybe < Minimum) {
                Minimum = resultsMaybe;
        }
    }    

    //setting up all the threads for minimumPairwiseDistance
	@Override
	public int minimumPairwiseDistance(int[] values) {
    Thread LL = new Thread(new LL(values));
	Thread BR = new Thread(new BR(values));
	Thread TR = new Thread(new TR(values));
	Thread C = new Thread(new C(values));
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
	//lMinimum is the local min for each thread so it can refer back to the overall min
	
	class LL implements Runnable {
	       //create variable to store the newly found possible minimum
	       int lMinimum = Integer.MAX_VALUE;
	       int[] values;


	LL(int[] values) {
		this.values = values;
	}	
	//Thread then runs the following nest for loops, looping over its area to find the minimum value of
	//that area
	//then checks the current global min to the found min, if the found min is lower it updates the global
	//the area checked by the for loop changes for each thread.

	public void run() {
		for (int i = 0; i < values. length/2; i++) {
    			for (int j = 0; j < i; j++) {
				int difference = Math.abs(values[i] - values[j]);
		    		if (difference < lMinimum) {
			    		lMinimum = difference;
				    }
		}

	}
	updateGlobalResult(lMinimum);

    }
}
	class BR implements Runnable {
			   int lMinimum = Integer.MAX_VALUE;
               int[] values;
       BR(int[] values) { 
              this.values = values;
        }
       
        public void run() {
                for (int i = values.length/2; i < values. length; i++) {                
                        for (int j = 0; j < i - (values.length/2); j++) {
                                int difference = Math.abs(values[i] - values[j]);
                                if (difference < lMinimum) {
                                        lMinimum = difference;
                                    }
                }
                
        }
        updateGlobalResult(lMinimum);
    }

}
	class TR implements Runnable {
		       int lMinimum = Integer.MAX_VALUE;
               int[] values;

        TR(int[] values) { 
                this.values = values;
        }
        
        public void run() {
                for (int i = values.length/2; i < values. length; i++) {                
                        for (int j = values.length/2; j < i; j++) {
                                int difference = Math.abs(values[i] - values[j]);
                                if (difference < lMinimum) {
                                        lMinimum = difference;
                                    }
                }
                
        }
        updateGlobalResult(lMinimum);

    }

}

	class C implements Runnable {
		       int lMinimum = Integer.MAX_VALUE;
               int[] values;

        C(int[] values) { 
                this.values = values;
        }
      
        public void run() {
                for (int i = values.length/2; i < values. length; i++) {                
                        for (int j = i - (values.length/2);j < values.length/2; j++) {
                                int difference = Math.abs(values[i] - values[j]);
                                if (difference < lMinimum) {
                                        lMinimum = difference;
                                    }
                }
                
        }
        updateGlobalResult(lMinimum);

    }

}



}

