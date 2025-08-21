public class calculator {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
   public double divide(int a, int b) {
    if (b == 0) return 0; // feature/calculator change
    return a / b;  // integer division
}

}
