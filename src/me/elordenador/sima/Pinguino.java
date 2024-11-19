package me.elordenador.sima;

public class Pinguino {
    private final int level;

    /**
     * Genera el pinguino
     */
    public Pinguino() {
        level = (int) Math.floor(Math.random() * 5) + 1;
    }

    /**
     * Devuelve el tipo del pinguino
     * @return El tipo del pinguino (String)
     */
    public String getType() {
        return switch (level) {
            case 1 -> "XS";
            case 2 -> "S";
            case 3 -> "M";
            case 4 -> "L";
            case 5 -> "XL";
            default -> "Unknown";
        };
    }

    public void print() throws InterruptedException {
        if (level == 1) {
            ScrUtils.slowPrint("(o_\n" +
                    "(/)_");
        }
        if (level == 2) {
            ScrUtils.slowPrint("""
                    (o_
                    //\\
                    V_/_""");
        }
        if (level == 3) {
            ScrUtils.slowPrint("""
                          .___.
                         /     \\
                        | O _ O |
                        /  \\_/  \\\s
                      .' /     \\ `.
                     / _|       |_ \\
                    (_/ |       | \\_)
                        \\       /
                       __\\_&gt;-&lt;_/__
                       ~;/     \\;~""");
        }
        if (level == 4) {
            ScrUtils.slowPrint("""
                            /@@@@@@@\\
                          (@@@@@ # @@@@@\\
                         (` \\@@@@@@@@~~~~
                        /`    \\@@@@@|
                       /@@     ''''  \\
                      /@@@@\\          |
                     /@@@@@@@\\        |
                    /@@@@@@@@@        |
                    |@@@@@@@@         |
                    |@@@@@@@          |
                    |@@@@@@@          |
                    |@@@'@@@@        |
                    |@@@ '@@@        ;
                    |@@@  @@;       ;
                    |@@@  ''       ;
                    (@@@@         ;
                     (@@@@        |
                      (__@@_______)""");
        }
        if (level == 5) {
            System.out.println("""
                                                        ooo
                                                   ooo$$$$$$$$$$$oo
                                                o$$$$$$$$$$$$$$$$$$$ooo
                                              o$$$$$$$$$$$$$$$$$"$$$$$$$oo
                                           o$$$$$$$$$$$$$$$$$$$  o $$$$$$$$$$$$$$oooo
                                          o$$$$""\"$$$$$$$$$$$$$oooo$$$$$$$$$$$$$""\"
                                        oo$""      "$$$$$$$$$$$$$$$$$$$$$$$$"
                                       o$$          $$$$$$$$$$$$$$$$$$$$$$"
                                      o$$            $$$$$$$$$$$$$$$$$$$$
                                    o$$$$             $$$$$$$$$$$$$$$$$"
                                   o$$$$$$oooooooo "                $"
                                  $$$$$$$$$$$$$$"
                                 $$$$$$$$$$$$$$
                                o$$$$$$$$$$$$$                         o
                               o$$$$$$$$$$$$$                           o
                              o$$$$$$$$$$$$$$                            "o
                             o$$$$$$$$$$$$$$$                             "o
                            o$$$$$$$$$$$$$$$$                              $
                           o$$$$$$$$$$$$$$$$"                              "
                           $$$$$$$$$$$$$$$$$                                $
                          o$$$$$$$$$$$$$$$$$                                $
                          $$$$$$$$$$$$$$$$$                                 $
                         $$$$$$$$$$$$$$$$$$                                 "
                         $$$$$$$$$$$$$$$$$                                   $
                        $$$$$$$$$$$$$$$$$                                    $
                        $$$$$$$$$$$$$$$$"                                    $$
                       $$$$$$$$$$$$$$$$$                                      $o
                       $$$$$$$$$$$$$$$$$                                      $$
                      $$$$$$$$$$$$$$$$$$                                       $
                      $$$$$$$$$$$$$$$$$$o                                      $$
                     $$$$$$$$$$$$$$$$$$$$o                                     $$
                     $$$$$$$$$$$$$$$$$$$$$$o                                   "$
                     $$$$$$$$$$$$$$$$$$$$$$$$o                                  $
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$                                 $$
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$                                $$
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$                               $$
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$o                              $$
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$o                             $$
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                             $$
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                             $"
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                            $$
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                            $"
                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                            $
                     $$$$$$$$$$$$$$$$$$$$$$$$$$$$$                            o$
                     $$$$$$$$$$$$$$$$$$$$$$$$$$$$$                            $"
                     $$$$$$$$$$$$$$$$$$$$$$$$$$$$"                            $
                     $$$$$$$$$$$$$$$$$$$$$$$$$$$"                             $
                      $$$$$$$$$$$$$$$$$$$$$$$$$"                             $$
                      $$$$$$$$$$$$$$$$$$$$$$$$"                              $$
                      $$$$$$$$$$$$$$$$$$$$$$$                                $$
                       $$$$$$$$$$$$$$$$$$$$$                                o$$
                       $$$$$$$$$$$$$$$$$$$$                                 $$"
                       "$$$$$$$$$$$$$$$$$$                                  $$
                        $$$$$$$$$$$$$$$$$                                  o$$
                        "$$$$$$$$$$$$$$$"                                  $$
                         $$$$$$$$$$$$$$$                                   $$
                         "$$$$$$$$$$$$$"                                  o$
                          $$$$$$$$$$$$"                                   $$
                          $$$$$$$$$$$"                                    $$
                           $$$$$$$$$"                                    $$"
                           $$$$$$$$$                                     $$
                           "$$$$$$$"                                    $$
                            $$$$$$$o                                    $"
                           o$$$$$$$$                                   $$
                           $$$$$$$$$                                   $$
                          o$$$$$$$$$                                   $"
                          $$$$$$$$$$                                  $$
                          "$$$$$$$$$                                o$""
                           "$$$$$$$$                          ooooo$$oo
                              ""$$$$$o                oooo$$$$$$$$$$$$$$ooo
                                 "$$$$$$ooooooo     ""\"""\"""\"$$$""\""$$o   ""
                                                                      \"""");

        }
    }

    /**
     * Devuelve los puntos de vida que ganaria o perderia, es aleatorio cada vez que se ejecute.
     * @return Los puntos de vida.
     */
    public int getCoins() {

        return (int) Math.floor(Math.random() * 9) + ((10*(level - 1)) + 1);
    }

    /**
     * Función logica de ataque
     * @return true si ha ganado la pelea o false si la ha perdido
     */
    public boolean attack() {
        int diceresult = (int) Math.floor(Math.random() * 6) + 1;
        if (level == 1) {
            return diceresult >= 2;
        } else if (level == 2) {
            return diceresult >= 3;
        } else if (level == 3) {
            return diceresult >= 4;
        } else if (level == 4) {
            return diceresult >= 5;
        } else {
            return diceresult == 6;
        }
    }
}
