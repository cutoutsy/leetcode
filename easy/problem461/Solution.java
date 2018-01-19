public class Solutiion461 {
    public int hammingDistance(int x, int y)
    {
        int result = 0;
        for (int i = 0; i < 31; i++)
        {
            byte xByte = (byte)((x >> i) & 1);
            byte yByte = (byte)((y >> i) & 1);
            if((xByte ^ yByte) == 1)
            {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solutiion461 solution = new Solutiion461();
        int result = solution.hammingDistance(1, 4);
        System.out.println("Hamming Distance: " + result);
    }
}
