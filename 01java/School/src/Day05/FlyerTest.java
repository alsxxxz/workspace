package Day05;
public class FlyerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IFyler f = new Bird();
		f.fly();
		System.err.println();
		
		IFlyer[] fa = new IFlyer[3];
	
		fa[0] = new Airplane();
		fa[1] = f;
		fa[2] = new Superman();
		for(IFlyer t:ta) t.fly();
		interface IA{
			
		}
		interface IB{
		}
		
		interface IFLayer extends IA,IB{
			public static final int i =11;
								int j =22;
			public abstract void fly();
							void land();
							void takeOff();
		}
		
class Airplane implements IFlyer{
	@Override
	public void fly() {
		System.out.println("비행기가 난다.");
	}
	public void takeOff() {}
}
	}
class Birds implements IFlyer{
	@Override
	public void Birds() {
		System.out.println("비행기가 난다.");
	}
	public void takeOff() {}
}
class Birds implements FlyerTest{
	@Override
	public void Birds() {
		System.out.println("비행기가 난다.");
	}
	public void takeOff() {}
}
}
