import java.io.*;//データストリーム、ファイルシステム入出力用のパッケージの呼び出し
import java.net.*;//ネットワーク・アプリケーションを実装するためのパッケージの呼び出し

public class c {
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
			

        

            //ターミナルに身長を入力してくださいと表示
			System.out.println("身長を入力してください(cm)");
            //Keyboardから入力された数字を格納するためのdouble型のheightを定義し、Double.parseDoubleメソッドを用いて，
            //ストリーム型の値をDouble型に変換し，heightに代入
			double height= Double.parseDouble(KBIn.readLine());
            //入力された値をサーバーに送信
            out.println(height);
            //ターミナルに体重を入力してくださいと表示
            System.out.println("体重を入力してください(kg)");
            //Keyboardから入力された数字を格納するためのdouble型のweightを定義し、Double.parseDoubleメソッドを用いて，
            //ストリーム型の値をDouble型に変換し，weightに代入
            double weight= Double.parseDouble(KBIn.readLine());
            //入力された値をサーバーに送信
            out.println(weight);
			
            //Line12: Sting型の"answer"を定義し，in.readline()を用いて"answer"に格納
            String answer = in.readLine();
            //Line12: Sting型の"answer2"を定義し，in.readline()を用いて"answer"に格納
            String answer2 = in.readLine();
            //"answer"をターミナルに表示
			System.out.println("あなたのBMIは" + answer+"です");
            //"answer2"をターミナルに表示
            System.out.println(answer2);

            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}