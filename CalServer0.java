import java.io.*; //ータストリーム、ファイルシステム入出力用のパッケージの呼び出し
import java.net.*;//ネットワーク・アプリケーションを実装するためのパッケージの呼び出し

public class CalServer0{
    public static final int PORT = 1234; //Well Known 意外の任意のポート番号の指定
    
	public static void main(String args[]) { 	//メインクラスの始まり！
        ServerSocket serverSocket = null;		//ServerSocket型のserverSocketの定義・初期化
        Socket socket = null;					//Socket型のsocketの定義・初期化
        try {
            //Line1 : serverSocketの生成(PORTを引数に)
			serverSocket = new ServerSocket(PORT);
            //Line2 :サーバが起動したことをprintlnとgetLocalPort()を
			//使用してサーバのターミナルに表示させる
			System.out.println("計算サーバが起動しました(port=" + serverSocket.getLocalPort() + ")");
			//Line3 : accept()を用いてクライアントからの要求を待ち続ける
            socket = serverSocket.accept(); 
			//Line4 :クライアントがサーバが接続したことをprintlnと
			//getRemoteLocalAddress()を使用してサーバのターミナルに表示させる
            System.out.println("計算サーバに接続されました" + socket.getRemoteSocketAddress());
			//Line5 :
			//クライアントからの送信されるデータを読み込むためのBufferedReader型の
			//インスタンスinをInputStreamReaderとgetInputStream()を用いて生成
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//Line6 :
			//クライアントからの送信されるデータを読み込むための PrintWriter型の
			//インスタンスoutをPrintWriterとgetOutputStream()を用いて生成
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			//Line7 :２数の和を格納するdouble型の変数sumを定義
            double sum = 0;
			//Line8 :クライアントから送信された２数の格納するdouble型の
			//変数input1, input2を定義
			double input1, input2;
			//Line9: Double.parseDoubleメソッドを用いて，クライアントから
			//送信されたストリーム型の値をDouble型に変換し，input1に代入
            input1 = Double.parseDouble(in.readLine());
			//Line10: Double.parseDoubleメソッドを用いて，クライアントから
			//送信されたストリーム型の値をDouble型に変換し，input2に代入
			input2 = Double.parseDouble(in.readLine());
			//Line11: input1とinput2の値をsumに代入
			sum = input1 + input2;
            
			//sumをクライアント結果に返す
            out.println(String.valueOf(sum));
			//例外処理
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
