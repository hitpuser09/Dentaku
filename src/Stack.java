//スタック領域
public class Stack {

	private int stackSize;			//スタックのサイズ
	private int stackPointer;		//スタックポインタ
	private String[] stack_str;		//スタック領域（String型）

	//コンストラクタ
	public Stack(int size) {
		this.stackPointer = 0;			//スタックポインタを0で初期化
		this.stackSize = size;			//スタックサイズを設定

		stack_str = new String[stackSize];		//スタック領域を指定したサイズで生成
	}


	//スタックに格納（格納後はポインタを＋1）
	public String push(String str){
		if (stackPointer >= stackSize) {
			throw new StackOverflowException();
		}
		return stack_str[stackPointer++] = str;		//ポインタ…＋1
	}

	//スタックから取り出し（先にポインタを－1してから）
	public String pop(){
		if(stackPointer <= 0){
			throw new EmptyStackException();
		}
		return stack_str[--stackPointer];		//ポインタ…－1
	}

	//スタックの最上段を取得
	public String peek(){
		if(stackPointer <= 0){
			throw new EmptyStackException();
		}
		return stack_str[stackPointer -1];
	}


	//スタックのサイズを超えた場合
	public class StackOverflowException extends RuntimeException {
		public StackOverflowException() {
			super("スタックのサイズを超えています！");
		}
	}

	//スタックが空の時
	public class EmptyStackException extends RuntimeException {
		public EmptyStackException () {
			super("スタックが空ですよ！");
		}
	}
}
