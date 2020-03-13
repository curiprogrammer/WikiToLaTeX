# WikiToLaTeX
This tool should take Wikipedia code and turn it into LaTex code.

# What it does
* It takes all ":<math>" and turns them into "\begin{equation} \n" and takes the corresponding "</math>" and turns it into "\end{equation}"
* It takes all the rest of the "<math>" and "</math>", turning them into "$"
* It removes the inner Wikipedia linking "[[text 1|text 2]]" -> "text 2"
* It removes "<!-- some text -->"
* It removes the references "<ref> ... </ref>"
