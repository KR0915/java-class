public class StringExamples {
    public static void main(String[] args){
        //文字列の定義
        String greeting="Hello World";

        //length()-文字列の長さを取得
        System.out.println("Length:"+greeting.length());//出力13

        //charAt() -部分文字列を取得
        System.out.println("Character at position 7:"+greeting.charAt(7));//出力W

        //substring() -文字列を取得
        System.out.println("Substring form 7 to 12:"+greeting.substring(7,13));// World!

        //equals() -文字列が等しいかどうか比較
        String anotherGreeting="Hello,World";
        System.out.println("Equals:"+greeting.equals(anotherGreeting));//出力true

        //toLLowerCase()とtoUpperCase() -大文字と小文字の変換
        System.out.println("Lowercase:"+greeting.toLowerCase());//
        System.out.println("Lowercase:"+greeting.toUpperCase());//

        //contains() -文字列がしてした文字列を含めるかどうか
        System.out.println("Contains 'World':"+greeting.contains("World"));//出力True
    }
}

