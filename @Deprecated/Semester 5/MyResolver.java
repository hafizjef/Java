import java.net.InetAddress;
public class MyResolver
{
        public static String resolveIP(String dns) throws Exception
        {
                InetAddress inet = InetAddress.getByName(dns);
                return inet.getHostAddress();
        }
       
        public static String[] resolveIPs(String dns) throws Exception
        {
                InetAddress inet[] = InetAddress.getAllByName(dns);
                String IPAdd[] = new String[inet.length];
                for (int i=0; i<inet.length; i++)
                {
                        IPAdd[i] = inet[i].getHostAddress();
                }
                return IPAdd;
        }
       
        public static String resolveDNS(String ip) throws Exception
        {
                InetAddress inet = InetAddress.getByName(ip);
                return inet.getHostName();
               
        }
       
        public static void main(String[] args) throws Exception
        {
                String ip1 = MyResolver.resolveIP("www.poliku.edu.my");
                System.out.println(ip1);
                System.out.println("");
               
                System.out.println(MyResolver.resolveIP("www.facebook.com"));
                System.out.println("");
               
                for(String ip : MyResolver.resolveIPs("www.gmail.com"))
                System.out.println(ip);
               
                System.out.println("");
                String dns1 = MyResolver.resolveDNS("69.171.237.32");
                System.out.println(dns1);
               
                System.out.println("");
                System.out.println(MyResolver.resolveDNS("198.35.47.245"));
        }
}