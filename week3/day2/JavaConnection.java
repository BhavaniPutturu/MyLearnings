package week3.day2;

//to implement the interface "DatabaseConnection"
public class JavaConnection implements DatabaseConnection{

	public static void main(String[] args) {
		JavaConnection jc = new JavaConnection();
		jc.connect();
		jc.executeUpdate();
		jc.disconnect();
	}

	@Override
	public void connect() {
		System.out.println("Implementation of connect() method.");		
	}

	@Override
	public void disconnect() {
		System.out.println("Implementation of disconnect() method.");		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Implementation of executeUpdate() method.");		
	}

}
