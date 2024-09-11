/**
 * Imaginez une classe qui s'occupe des fractions. Oui, ces choses avec un numérateur en haut
 * et un dénominateur en bas. C'est exactement ce que fait notre classe Rational. Elle vous aide
 * à manipuler ces fractions, que ce soit pour les additionner, les comparer, ou juste les afficher
 * de manière sympa. Et ne vous inquiétez pas pour les réduire à leur forme la plus simple,
 * Rational s'en occupe tout seul comme un grand.
 * cette classe est là pour rendre les fractions un peu moins intimidantes.
 *@author Mohamed Boudabbous
 */
public class Rational {
    /**
     * Vous avez juste un nombre entier et vous voulez le transformer en fraction ?
     * Pas de problème, ce constructeur prend votre entier et le met sur 1.
     * Comme transformer 5 en 5/1, simple et efficace.
     *
     * @param numerator Votre entier, prêt à devenir le haut de la fraction.
     */
    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	     this.numerator = 1;
    }

    /**
     * Constructeur qui initialise le nombre rationnel avec un numérateur et un dénominateur donnés.
     * Le nombre est réduit à sa forme la plus simple.
     *
     * @param numerator   Le numérateur du nombre rationnel.
     * @param denominator Le dénominateur du nombre rationnel. Ne doit pas être 0.
     */
    public Rational(int numerator, int denominator) {
	     this.numerator = numerator;
         this.denominator = denominator;
         reduce();
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    // Les getters, setters, et autres méthodes sont commentés de manière similaire.

    // Exemple pour la méthode plus
    // Exemple pour la méthode plus
    /**
     * Additionner des fractions ? Laissez faire Rational. Donnez-lui une autre fraction,
     * et il l'additionne à celle-ci. Le résultat ? Une nouvelle fraction, propre et nette.
     *
     * @param other La fraction que vous voulez additionner à celle-ci.
     * @return Une nouvelle fraction, qui est la somme des deux.
     */
    public Rational plus(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Rational result = new Rational(newNumerator, newDenominator);
        reduce();
        return result;

    }

    public static Rational plus(Rational a, Rational b) {
        int newNumerator = a.numerator *b.denominator +a.numerator * b.denominator;
        int newDenominator = a.denominator * b.denominator;
        Rational result = new Rational(newNumerator, newDenominator);
        reduce();
        return result;
    }

    // Transforms this number into its reduced form

    public void reduce() {
        int gcd = this.gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
        Rational result = new Rational(this.numerator,this.denominator);

    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
        if (a<0) a = -a;
        if (b<0) b = -b;
        if (b == 0) return a;

    	while (a != b)
    	    if (a > b)
    		     a = a - b;
    	    else
    		     b = b - a;
    	return a;
    }

    public int compareTo(Rational other) {
        if (this.numerator * other.denominator < other.numerator * this.denominator) {
            return -1;
        }
        else if (this.numerator * other.denominator == other.numerator * this.denominator) {
            return 0;
        }
        else {
            return 1;
        }

    }

    public boolean equals(Rational other) {
      if (this.numerator == other.numerator && this.denominator == other.denominator) {
          return true;
      }
      else{
          return false;
      }
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
           result = String.valueOf(numerator);
    	} else {
    	    String numerator = String.valueOf(this.numerator);
            String denominator = String.valueOf(this.denominator);
            result = numerator + "/" + denominator;
    	}
    	return result;
    }

}
