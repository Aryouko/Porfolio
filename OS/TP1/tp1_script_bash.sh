function Addition() {
	local verif=1
	while ((verif)); do
		read -p "Entrez un numéro : " int1
		if [[ "$int1" =~ ^-?[0-9]+([.][0-9]+)?$ ]]; then
			verif=0
		else
            		echo "Entrée invalide. Veuillez entrer un nombre entier."
		fi
	done
	verif=1
	while ((verif)); do
		read -p "Entrez un numéro : " int2
		if [[ "$int1" =~ ^-?[0-9]+([.][0-9]+)?$ ]]; then
			verif=0
		fi
	done
	local res=$(echo "$int1 + $int2" | bc)
    	echo "Le résultat est : $res"
}
Addition
