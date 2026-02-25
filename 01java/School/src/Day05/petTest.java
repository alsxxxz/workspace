package Day05;

public class petTest {
	class A{
		
	}
	Class B{
		
	}
	
	//유일하게 인
	//메소드
	abstract Class Pet extends A /*B*/ implements Serial 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		private String name;
		
		public void speak() {
			System.out.println("?");
		}
		public Pet() {
		    this("펫");
		}

		public abstract void speak();

		public String getName() {
		    return name;
		}

		public void setName(String name) {
		    this.name = name;
		}
		public String getName() {
			return name;
		}
		public Pet(String name) {
			setName(name);
		}
		class duck extends Pets{
			public void speak() {
				System.out.println("멍");
			}
		}

		
	}

}
