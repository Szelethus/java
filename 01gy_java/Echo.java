public class Echo {
    public static void main(String[] args) {
		
		System.out.println("---===FOR LOOP ===---");
        for(int i = 0; i < args.length; i++)
			System.out.println(args[i]);
		
		System.out.println("---===WHILE LOOP ===---");
		int i = -1;
        while(++i < args.length)
			System.out.println(args[i]);
    }
}