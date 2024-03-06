// avec un niveau de difficulté du mot de passe faible, moyen, fort.
// Règles : si le mot de passe contient moins de 6 caracteres il est faible.
// S'il contient plus de 6 caracteres avec un symbole ou un nombre il est moyen.
// S'il contient plus de 9 caracteres avec un symbole et un nombre il est fort.

// Mettre en place une écoute sur le mdp

function mdpSecurity() {
    let inputPassword= document.getElementById("mdp");
    console.log(inputPassword);

    inputPassword.addEventListener("input", function helpForPassword(){
        let paswwordLength = inputPassword.value.length;
        const item=document.createElement("p");
        const contenu=document.createTextNode("Sécurité faible");
            if (paswwordLength<6) {
            item.appendChild(contenu);
            inputPassword.appendChild(item);
            };
    });
};
    // // Création des items <li>
    // const item = document.createElement('li');
    // // Création du texte
    // const contenu = document.createTextNode('valeur de i : ' + i);
    // // Association du texte à l'item <li>
    // item.appendChild(contenu);
    // // Ajout d'un identifiant sur chaque item <li>
    // item.setAttribute('id', 'li' + i);
    // // Insertion de l'item <li> à la liste <ul>
    // liste.appendChild(item);