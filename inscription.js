// avec un niveau de difficulté du mot de passe faible, moyen, fort.
// Règles : si le mot de passe contient moins de 6 caracteres il est faible.
// S'il contient plus de 6 caracteres avec un symbole ou un nombre il est moyen.
// S'il contient plus de 9 caracteres avec un symbole et un nombre il est fort.

// Mettre en place une écoute sur le mdp
let inputPassword= document.getElementById("password");

inputPassword.addEventListener("input", function helpForPassword(){
    let paswwordLength = inputPassword.length;
    if (paswwordLength<6) {
        
        function securityLevel() {
            
        }
    }
}
);