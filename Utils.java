/**
 * Classe utilitaire qui fournit des méthodes afin de manipuler des arrays de chaînes de caractères.
 * <p>
 * Cette classe contient des méthodes pour effectuer des opérations  sur des arrays de Strings,
 * comme  la recherche et le remplacement de mots.
 *
 * @author Mohamed Boudabbous
 */
public class Utils {

	/**
	 * Returns a copy of the array 'in' where each word occurring in the array
	 * 'what' has been replaced by the word occurring in the same position
	 * in the array 'with'.
	 *
	 * @param in an array of Strings;
	 * @param what an array of words to be replaced;
	 * @param with an array of replacement words;
	 * @return a new array idententical to 'in' except that all the occurrences of words
	 * found in 'what' have been replaced by the corresponding word from 'with'.
	 */
	/**
	 * Voici un petit outil pratique pour jouer avec les mots. Disons que vous avez une liste de phrases,
	 * et il y a certains mots spécifiques que vous voulez changer. Par exemple, dans toutes vos phrases,
	 * chaque fois que vous tombez sur "chat", vous voulez le remplacer par "tigre". Cette méthode est votre
	 * alliée pour ça. Vous lui donnez trois listes : la première, c'est vos phrases originales. La deuxième,
	 * c'est les mots que vous en avez assez de voir. Et la troisième, ce sont les nouveaux mots, bien plus
	 * intéressants, que vous voulez voir à leur place. Elle va fouiller dans vos phrases, repérer ces mots
	 * ennuyeux et les remplacer par les nouveaux. C'est comme une baguette magique pour vos textes !
	 * Mais attention, il y a un petit piège : si les listes des mots à remplacer et de leurs remplaçants
	 * n'ont pas la même taille, ou si l'une d'entre elles est vide, la magie ne fonctionnera pas et elle
	 * vous rendra un gentil 'null' pour vous dire qu'elle ne peut pas aider cette fois.
	 *
	 * @param in   Vos phrases originales, telles qu'elles sont.
	 * @param what Les mots que vous voulez éjecter de vos phrases.
	 * @param with Les nouveaux arrivants, les mots qui vont prendre la place des anciens.
	 * @return Un ensemble de phrases rafraîchies, avec les mots échangés. Si quelque chose cloche
	 *         avec les listes fournies, attendez-vous à un 'null' comme signe de non-action.
	 */
	public static String[] findAndReplace(String[] in, String[] what, String[] with) {

		String[] out = null; // The new array to be returned
		boolean valid = true; // True if the pre-conditions are satistified

		// Testing pre-conditions

		if (in == null || what == null || with == null) {
			valid = false;
		} else {
			if (what.length != with.length) {
				valid = false;
			}
		}

		if (valid) {

			out = new String[in.length];

			for (int i = 0; i < in.length; i++) {

				String inElement = in[i];
				if (inElement != null) {

					for (int j = 0; j < what.length; j++) {

						String whatElement = what[j];
						if (whatElement != null && inElement.equals(whatElement)) {

							String withElement = with[j];
							if (withElement != null) {
								out[i] = withElement;
								break;
							}
						}
					}
				}

				if (out[i] == null) {
					out[i] = in[i];
				}
			}
		}

		// Returning a reference to the newly created array that
		// contains the same entries as 'in' except that all the
		// occurrences of words from 'what' have been replaced by
		// their corresponding occurrence from 'with'.

		return out;

	}

}

