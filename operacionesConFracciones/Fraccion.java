class Fraccion {
//representacion

    private int a, b; 	//numerador y denominador

//constructores: inicializan repres. de objeto
    public Fraccion(int x, int y) {
        a = x;
        b = y;
        validar();
    }

    public Fraccion(String x) {
        int i = x.indexOf("/");
        if (i >= 0) {
            a = Integer.parseInt(x.substring(0, i));
            b = Integer.parseInt(x.substring(i + 1));
            validar();
        } else {
            a = Integer.parseInt(x);
            b = 1;
        }
    }

    private void validar() {//método interno
        if (b == 0) {
            U.abortar("denominador cero");
        }
    }
//métodos 

    @Override
    public String toString() {
        return a + "/" + b;
    }

    public Fraccion suma(Fraccion x) {
        return new Fraccion(a * x.b + b * x.a, b * x.b);
    }

    public Fraccion resta(Fraccion x) {
        return new Fraccion(a * x.b - b * x.a, b * x.b);
    }

    public Fraccion mult(Fraccion x) {
        return new Fraccion(a * x.a, b * x.b);
    }

    public Fraccion div(Fraccion x) {
        return new Fraccion(a * x.b, b * x.a);
    }

    public Fraccion simple() {
        int m = U.mcd(a, b);
        return new Fraccion(a / m, b / m);
    }

    public int compareTo(Fraccion x) {
        return a * x.b - b * x.a;//resultado: 0, <0 o >0
    }
}
