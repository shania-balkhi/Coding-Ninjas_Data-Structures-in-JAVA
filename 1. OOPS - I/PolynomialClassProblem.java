class Polynomial {
    int[] poly;

    Polynomial() {
        poly = new int[10];
    }

    /*
     * This function sets coefficient for a particular degree value, if degree is
     * not there in the polynomial
     * then corresponding term(with specified degree and value is added int the
     * polynomial. If the degree
     * is already present in the polynomial then previous coefficient is replaced by
     * new coefficient value passed as function argument
     */
    public void setCoefficient(int degree, int coeff) {

        if (degree > poly.length - 1) {
            // doubleCapacity();
            int[] temp = poly;
            poly = new int[degree + 1];
            for(int i = 0; i < temp.length; ++i){
                poly[i] = temp[i];
            }
        }
        poly[degree] = coeff;

    }


    // Prints all the terms(only terms with non zero coefficients are to be printed)
    // in increasing order of degree.
    public void print() {

        for (int i = 0; i < poly.length; ++i){
            if (poly[i] != 0){
                System.out.print(poly[i] + "x" + i + " ");
            }
        }
        // System.out.println();

    }

    // Adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p) {

        Polynomial ans = new Polynomial();
        int p1len = this.poly.length;
        int p2len = p.poly.length;
        int len = Math.min(p1len, p2len);

        int i;
        for (i = 0; i < len; ++i){
            ans.setCoefficient(i, this.poly[i] + p.poly[i]);
        }

        while(i < p1len){
            ans.setCoefficient(i, this.poly[i]);
            ++i;
        }

        while(i < p2len){
            ans.setCoefficient(i, p.poly[i]);
            ++i;
        }

        return ans;

    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p) {

        Polynomial ans = new Polynomial();
        int p1len = this.poly.length;
        int p2len = p.poly.length;
        int len = Math.min(p1len, p2len);

        int i;
        for (i = 0; i < len; ++i){
            ans.setCoefficient(i, this.poly[i] - p.poly[i]);
        }

        while(i < p1len){
            ans.setCoefficient(i, this.poly[i]);
            ++i;
        }

        while(i < p2len){
            ans.setCoefficient(i, -p.poly[i]);
            ++i;
        }

        return ans;

    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p) {
        Polynomial ans = new Polynomial();
        for (int i = 0; i < this.poly.length; ++i){
            for (int j = 0; j < p.poly.length; ++j){
                int degreeOfTheTerm = i + j;
                int newCoefficientOfTheTerm = this.poly[i] * p.poly[j];
                int oldCoefficientOfTheTerm = ans.getCoefficient(degreeOfTheTerm);
                ans.setCoefficient(degreeOfTheTerm, oldCoefficientOfTheTerm + newCoefficientOfTheTerm);
            }
        }
        return ans;
    }

    private int getCoefficient(int degreeOfTheTerm){
        if (degreeOfTheTerm >= this.poly.length){
            return 0;
        }
        return poly[degreeOfTheTerm];
    }

}
