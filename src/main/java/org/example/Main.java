package org.example;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String[] strs = {"pôle","pantalon","pentagone"};
        String result = main.longestCommonPrefix(strs);
        System.out.println("Préfixe commun : " + result);
    }
    public String longestCommonPrefix(String[] strs) {
        /*
        Lorsque le tableau est vide , il y a pas de prefixes
         */
        if (strs.length == 0) {
            return "Le tableau est vide";
        }
        /*
        Lorsque le tableau contient un seul élément, l'élément est lui même le prefixe
         */
        if (strs.length == 1) {
            return strs[0];
        }
        /*
        Trouver la longueur minimale parmi les chaines de caractères
        Car le prefixe commun ne peut pas être plus long que la plus courte chaîne de caractère du tableau
        -on definit une variable minLen avec la plus grande longueur possible
        -Ensuite chaque chaine de caractère est parcouru, et sa taille est stockée dans minLen
        -Ainsi à la fin minLen contiendra la plus petite longueur
         */
        int minLen = Integer.MAX_VALUE;
        for ( int i = 0; i < strs.length; ++i ) {
            minLen = Math.min(minLen, strs[i].length());
        }
        //Variable utilisée pour stocker la longueur maximum
        int maxLen = 0;
        /*
        Parcours des indices de longueur de prefixes possibles
        -La boucle commence à partir de minLen qui est la plus courte chaine de caractère
        -A chaque itération on vérifie si toutes les chaines ont le même prefixe de longuerur i
         */
        for (int i = minLen; i >= 0; --i)  {
            /*
            La variable booléenne samePrefix est utilisée pour suivre si toutes les chaînes
        ont le même préfixe de longueur i. Elle est initialement définie sur true.
             */
            boolean samePrefix = true;
            /*
            La sous-chaîne prefix est extraite de la première chaîne dans le tableau strs.
            Cette sous-chaîne commence à l'index 0 et se termine à l'index i - 1.
             */
            String prefix = strs[0].substring(0, i);

            /*
            -Une autre boucle for pour parcourir toutes les chaînes dans le tableau strs (de j = 0 à j < strs.length)
            -Dans cette boucle, chaque chaîne est vérifiée pour voir si elle commence par le préfixe extrait (prefix). Si ce n'est pas le cas,
            la variable samePrefix est définie sur false et la boucle interne est interrompue à l'aide de break..
             */
            for ( int j = 0; j < strs.length; ++j) {
                if ( !strs[j].startsWith(prefix) ) {
                    samePrefix = false;
                    break;
                }
            }
            /*
            -Et lorsque chaque chaîne commence par le préfixe extrait; c'est à dire la variable
            samePrefix est true , par consequent maxLen est mis à jour par la valeur
            actuelle de i.
            -maxLen contiendra la longueur du préfixe commun le plus long.
             */
            if ( samePrefix ) {
                maxLen = Math.max(maxLen, i);
            }
        }
        /*Retour de la sous-chaine du premier élement dans le tableau
        en commencant par l'index 0 jusqu'à maxLen - 1 , qui est le prefix commun le plus long
         */
        return strs[0].substring(0, maxLen);
    }
}