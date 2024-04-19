import java.io.*; //ータストリーム、ファイルシステム入出力用のパッケージの呼び出し
import java.net.*;//ネットワーク・アプリケーションを実装するためのパッケージの呼び出し

public class s{
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
			

            
            //クライアントから入力された体重と身長を格納するための変数を定義
			double weight, height;
			
            //Double.parseDoubleメソッドを用いて，クライアントから送信されたストリーム型の値をDouble型に変換し，heightに代入
			height = Double.parseDouble(in.readLine());
            //Double.parseDoubleメソッドを用いて，クライアントから送信されたストリーム型の値をDouble型に変換し，weightに代入
            weight = Double.parseDouble(in.readLine());
			
            //heighとweightの値をbmiに代入
			double bmi = weight / ((height / 100) * (height / 100));
            
            //bmiの値を評価する文字列を格納する変数を定義
            String msg="";

            //bmiの値が25以上、18.5以上25未満、18.5未満それぞれで評価し、その結果をmsgに代入
            if(bmi >= 25) {
                msg="肥満です";
            } else if(bmi < 25 && bmi >= 18.5) {
                msg="普通です";
            } else if(bmi < 18.5) {
                msg="スリムです";
            }

            //bmiの値をクライアントに返す
            out.println(String.valueOf(bmi));

            //bmiを評価した文字列をクライアントに返す
            out.println(msg);

			//例外処理
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
