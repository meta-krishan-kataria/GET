
public class MyArrayList <E> {
	/**
	 * 
	 * Conventions:
	 * 
	 * 'capacity' implies total length of array whether filled or unfilled
	 * 'size' implies length of elements which are filled 
	 * 
	 * */
	
	private Object[] data;
	
	private final int DEFAULT_CAPACITY=10;
	private final int DEFAULT_INCREMENT=10;
	
	private int size=0;	//-1 implies empty array list
	
	/**Constructor with no argument
	*/
	public MyArrayList(){
		data=new Object[ DEFAULT_CAPACITY ];
	}
	
	/**Constructor with argument for initial capacity
	*/
	public MyArrayList( int initialCapacity ){
		data=new Object[ initialCapacity ];
	}
	
	/**
	 * returns size of array
	 * */
	public int getSize(){
		return size;
	}
	
	/**
	 * returns capacity of array
	 * */
	public int getCapacity(){
		return data.length;
	}
	
	
	
	
	/**
	 * Ensures capacity of array
	 * */
	private boolean ensureCapacity(){
		if( data.length - size > 1 ){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Ensures capacity of array with minimum required 
	 * */
	private boolean ensureCapacity(int minimumRequired){
		if( data.length - size >= minimumRequired  ){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * Increments array capacity
	 * */
	private void increaseCapacity(){
		//copying array to temp
		Object[] temp=clone(data);
		//creating new array
		data=new Object[temp.length + DEFAULT_INCREMENT ];
		//copying elements to new increased sized array
		for( int i=0; i<temp.length; i++ ){
			data[i]=temp[i];
		}
	}
	
	/**
	 * clones the array 
	 * */
	public Object[] clone(Object[] o){
		Object[] copy=new Object[o.length];
		for(int i=0; i < o.length; i++){
			copy[i]=o[i];
		}
		return copy;		
	}
	
	/**
	 * function to append element 
	 * */
	public void add(E e){
		if( ensureCapacity() == true){	//have enough capacity
			data[size++]=e;
			
		}else{							//no sufficient capacity
			increaseCapacity();			//increasing size
			data[size++]=e;
			
		}
	}
	
	/**
	 * adds element at particular index
	 * @throws ArrayIndexOutOfBoundsException for invalid index
	 * */
	public void addAt(E e,int index){
		if( index < 0 || index > getSize()){
			throw new ArrayIndexOutOfBoundsException();
		}

		//maintaining capacity
		maintainCapacity();
		//shifting latter elements of the array
			// size is n means last index of filled element is n-1
		for( int i=size ; i > index; i-- ){
			data[i]=data[i-1];
		}
		//placing e
		data[index]=e;
		//updating size
		size++;
	}
	
	/**
	 * returns list element form the index
	 * */
	public Object get(int index){
		
		Object o = null;
		
		try {
			o= data[index];
			
		} catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Invalid index");
			e.printStackTrace();
		}
		return o;
	}
	
	
	/**
	 * maintains capacity, check capacity and increments if required
	 * */
	private void maintainCapacity(){
		
		//checking capacity
		boolean isSufficient=ensureCapacity();
		//incrementing if required
		if(isSufficient==false){
			increaseCapacity();
		}
		
	}
	
	/**
	 * returns first index of item in the list
	 * */
	/*
	public int find(E e){
		for(int i=0; i < getSize(); i++){
			if
		}
		
	}
	*/
	
	
	
}
