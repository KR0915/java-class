import java.io.*;//データストリーム、ファイルシステム入出力用のパッケージの呼び出し
import java.net.*;//ネットワーク・アプリケーションを実装するためのパッケージの呼び出し

public class CalClient00 {
    public static final int PORT = 1234; //Well Known 意外の任意のポート番号の指定

    public static void main(String args[]) {//メインクラスの始まり！
        Socket socket = null;				//Socket型のsocketの定義・初期化
        try {
			//Line1 :ターミナルから入力されたアドレス・ホスト名をもとに
			//socketのインスタンスを生成
            socket = new Socket(args[0], PORT);
			//Line2 :クライアントがサーバが接続したことをprintlnとサーバのアドレスを
			//getRemoteLocalAddress()を使用してクライアントのターミナルに表示させる
            System.out.println("加算サーバ" + socket.getRemoteSocketAddress()+"に接続しました");
			//Line3: サーバからの送信されるデータを読み込むためのBufferedReader型の
			//インスタンス"in"をInputStreamReaderとgetInputStream()を用いて生成
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //Line4 :
			//サーバからの送信されるデータを書き出すための PrintWriter型の
			//インスタンス"out"をPrintWriterとgetOutputStream()を用いて生成
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//Line5 :
			//キーボードから入力されるデータを読み込むための BufferedReader型の
			//インスタンス"KBIn"をBufferedReaderとInputStreamReader(System.in)を用いて生成
            BufferedReader KBIn = new BufferedReader(new InputStreamReader(System.in));
			
			//Line6 : 
			//Keyboardから入力された数字を格納するためのdouble型のin1, in2を定義
            double in1,in2 ;
            //Line7 : "加算を行う2つの値を入力してください"とターミナルに表示させる
			System.out.println("加算を行う2つの値を入力してください");
			//Line8 : Double.parseDoubleメソッドを用いて，キーボードから
			//入力されたストリーム型の値をDouble型に変換し，in1に代入
			in1 = Double.parseDouble(KBIn.readLine());
			System.out.println("一つ目の数字は " + in1);
			//Line9 : 入力された値をサーバに送信
			out.println(in1);
			//Line10: 入力されたストリーム型の値をDouble型に変換し，in2に代入
			in2 = Double.parseDouble(KBIn.readLine());
			System.out.println("２つ目の数字は " + in2);
			//Line11: 入力された値をサーバに送信
			out.println(in2);

			//Line12: Sting型の"answer"を定義し，in.readline()を用いて
			//"answer"に格納
            String answer = in.readLine();
            //"answer"をターミナルに表示
			System.out.println("結果: " + answer);

            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
