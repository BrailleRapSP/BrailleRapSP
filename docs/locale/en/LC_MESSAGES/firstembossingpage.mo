��    	      d               �   6   �   ,  �   D        V  x   o  (   �  '     7  9  �  q  *   �  "  "  8   E     ~  G   �  (   �       �      Aller sur la page https://crocsg.github.io/BrailleRap/ BrailleRapSP est est machine qui se pilote en G-CODE, pour embosser du braille il faut tout d'abord traduire le texte en Braille. Il existe 2 solutions pour traduire le Braille : L'application BrailleRap en ligne https://crocsg.github.io/BrailleRap/ L'application NatBraille http://natbraille.free.fr Compiler les programmes dans le repertoire NatBrailleTools du projet Configuration NatBraille Dans les options de mise en page, indiquer 31 et 26 dans le nombre de caracter par ligne et le nombre de lignes par page Embosser votre première page de Braille Utilisation de l'application BrailleRap le paramêtre  pour commande d'impression est : **java -jar d:\\usr\\home\\logger\\BrailleLogger.jar $f | java -jar d:\\usr\\home\\logger\\gcodestreamer.jar COM4 250000** en modifiant eventuellement les repertoires d'installation des programmes COM4 est le port serie utilisé pour communiquer avec l'imprimante Project-Id-Version:  BraillerRapSP
Report-Msgid-Bugs-To: 
POT-Creation-Date: 2018-12-28 10:31+0100
PO-Revision-Date: 2018-12-28 11:56+0200
Last-Translator: Stephane <braillerapsp@gmail.com>
Language: en
Language-Team: braillerapsp
Plural-Forms: nplurals=2; plural=(n != 1)
MIME-Version: 1.0
Content-Type: text/plain; charset=utf-8
Content-Transfer-Encoding: 8bit
Generated-By: Babel 2.6.0
 go to https://crocsg.github.io/BrailleRap/ BrailleRapSP is a  G-CODE drivnd machine, to emboss braille it is necessary first of all to translate the text in Braille. There are 2 solutions to translate Braille: The BrailleRap application online https://crocsg.github.io/BrailleRap/ The NatBraille application http://natbraille.free.fr Build software in the NatBrailleTools project directory  NatBraille configuration In page settings enter 31 and 26 as caracter per line and line per page Embosser votre première page de Braille Using BrailleRap App use the parameter  **java -jar d:\\usr\\home\\logger\\BrailleLogger.jar $f | java -jar d:\\usr\\home\\logger\\gcodestreamer.jar COM4 250000** for printer command. You need to modify the executable directory and the COM port reference 