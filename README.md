# EscapeGameOnline
Hello World ! Bienvenue dans Escape Game Online !

Comment éxécuter l'application : 

      - Sur IDE: 1/ Ouvrir le projet; 
                 2/ Importer les packages necessaire pour le bon fonctionnement du programme; 
                 3/ Cliquer sur Main.java; 
                 4/ Cliquer sur Executer le programme; 
                 5/ Une fois le jeu lancé, suivre les instructions du jeu affichées dans le terminal de votre IDE.

      - Sur l'invit de commande: 1/ Se placer dans le dossier out\artifacts\Escape_Game_ONLINE_jar;
                                 2/ Vérifier que la version du compilateur et de java correspondent: tapper les commandes javac --version, puis: java --version;
                                 3/ Si les versions ne correspondent pas, compiler l'ensemble des fichiers .java en spécifiant le chemin vers les librairies nécessaires avec la commande javac suivie de l'adresse des fichiers à compiler : 
                                    javac [options] [fichiers source ] [@files]; ( pour plus d'informations concernant les différentes options de compilation : http://lampwww.epfl.ch/~linuxsoft/java/jdk1.3/docs/tooldocs/solaris/javac.html )
                                 4/ Tapper la commande suivante: java -jar Escape_Game_ONLINE.jar;
                                 5/ Une fois le jeu lancé, suivre les instructions du jeu.


Les modes de jeu :
      
      1/ Challenger : vous devez deviner la combinaison secrète du système.
      2/ Défenseur : Le système tente de deviner votre combinaison secrète.
      3/ Duel : Le premier qui trouve la combinaison de l'autre a gagné.

Le mode développeur permettant de voir la combinaison de la machine, ainsi que le nombre d'essais et le nombre de chiffres à découvrir sont définis dans le fichier Config.properties.

GOOD GAME !
