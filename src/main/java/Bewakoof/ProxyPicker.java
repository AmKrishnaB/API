package Bewakoof;

public class ProxyPicker {
        static String[] proxyList = {"154.6.99.144:3128",
                "38.62.223.22:3128",
                "154.6.96.163:3128",
                "154.6.97.247:3128",
                "38.62.221.128:3128",
                "38.62.223.198:3128",
                "38.62.223.27:3128",
                "154.6.98.91:3128",
                "154.6.99.56:3128",
                "154.6.98.183:3128",
                "38.62.222.135:3128",
                "38.62.221.219:3128",
                "154.6.97.58:3128",
                "154.6.98.229:3128",
                "38.62.221.224:3128",
                "154.6.96.0:3128",
                "154.6.96.76:3128",
                "38.62.223.220:3128",
                "38.62.221.174:3128",
                "154.6.97.28:3128"};

        private static int currentIndex = 0;

        public static String proxy() {
            String result = proxyList[currentIndex];
            currentIndex = (currentIndex + 1) % proxyList.length;
            System.out.println(currentIndex +"_"+ result);
            return result;
    }

}
