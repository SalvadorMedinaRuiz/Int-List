public class SortedIntList extends IntList{
	//-------------------------------------------------------------
	// Constructor -- creates an integer list of a given size.
	//-------------------------------------------------------------
	int rememberThisPlace;
	public SortedIntList(int size)
	{
		super(size);
	}
	
	 
	//-------------------------------------------------------------
	// Adds an integer to the list. If the list is full,
	// prints a message and does nothing.
	//-------------------------------------------------------------
	@Override
	public void add(int value)
	{
		if (numElements == list.length)
			System.out.println("Can't add, list is full");
		else
		{
			if(numElements==0) {
				list[0]=value;
			}
			else if(value >= list[numElements-1]) { //deals with last value
				rememberThisPlace=numElements; 
			}
			else if(value < list[0]) { //deals with first value
				rememberThisPlace= 0;
			}
			else {
				for (int i=0; i < numElements; i++) { //checks to see what number goes where
					if(list[i] >= value) {
						rememberThisPlace= i;
						break; // fix later
					}	
				}
				
			} 
		}
		for( int index =numElements-1; index >= rememberThisPlace ; index-- ) { //moves everything to the right
            list[index+1] = list [index];
		}
		list[rememberThisPlace]=value; //adds the current inserted value to the current index in the array
		numElements++; //increases the current index
	}
	
	//-------------------------------------------------------------
	// Returns a string containing the elements of the list with their
	// indices.
	//-------------------------------------------------------------
	public String toString()
	{
		String returnString = "";
		for (int i=0; i<numElements; i++)
			returnString += i + ": " + list[i] + "\n";
		return returnString;
	}
}
