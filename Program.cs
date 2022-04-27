using System;
using System.Text;
using System.Net.Sockets;
using System.Net.WebSockets;

namespace Client
{
    class Program
    {
        static void Main(string[] args)
        {
            string host = "localhost";
            int port = 80;
            byte[] bufor;
            try
            {
                string text = System.IO.File.ReadAllText(@"C:\Users\alicj\source\repos\Client\client.txt");
                byte[] data = System.Text.Encoding.ASCII.GetBytes(text);

                TcpClient socket = new TcpClient(host, port);
                NetworkStream netStream = socket.GetStream();
                netStream.Write(data, 0, data.Length);
                Console.WriteLine("Sent: {0} " + text);

                bufor = new byte[socket.ReceiveBufferSize];
                int length = netStream.Read(bufor, 0, socket.ReceiveBufferSize);
                String dataOut = Encoding.ASCII.GetString(bufor);
                Console.WriteLine("Received " + host);
                System.IO.File.WriteAllText(@"C:\Users\alicj\source\repos\Client\odp.txt", dataOut);

            }
            catch
            {
                Console.WriteLine("Something is wrong");
            }

        }
    }
}
