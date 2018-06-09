import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class RedisProtocol {
    public static void main(String[] args) {
        try {
            // 创建 socket
            Socket socket = new Socket("10.0.75.1", 6379);
            // 输出流(如果是客户端输出流即发送到服务端，如果是服务端输出流即发送到客户端)
            OutputStream os = socket.getOutputStream();
            // *3 共3个参数(get foo bar)
            // $4 参数的字节长度(MGET四字节长度，foo 和 bar 都是三字节长度)
            // 各个标记直接以 \r\n 隔开
            os.write("*3\r\n$4\r\nMGET\r\n$3\r\nfoo\r\n$3\r\nbar\r\n".getBytes());
            // 将输出流中的内容全部发出去
            os.flush();

            // 输入流 (这里是客户端所以读到的是服务端发送过来的内容)
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String ret;
            // 按行读取响应内容，readLine 会阻塞
            // 状态回复 (status reply) 的第一个字节是 "+"
            // 错误回复 (error reply) 的第一个字节是 "-"
            // 整数回复 (integer reply) 的第一个字节是 ":"
            // 批量回复 (bulk reply) 的第一个字节是 "$"
            // 多条批量回复 (multi bulk reply) 的第一个字节是 "*"
            while ((ret = reader.readLine()) != "") {
                System.out.println(ret);
            }
            // 关闭 socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
