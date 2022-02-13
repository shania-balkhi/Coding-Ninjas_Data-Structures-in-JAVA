public class ComplexNumbers {
		int real = 0;
	int imaginary = 0;
	public ComplexNumbers(int real, int imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}

	public void plus(ComplexNumbers c2){
		this.real = this.real + c2.real;
		this.imaginary= this.imaginary + c2.imaginary;
	}

	public void multiply(ComplexNumbers c2){
		int temp = this.real;
		this.real = ((this.real * c2.real) - (this.imaginary * c2.imaginary));

		this.imaginary = ((temp * c2.imaginary) + (c2.real * this.imaginary));
	}

	public void print(){
		System.out.println(real + " + i" + imaginary);
	}

	
}
