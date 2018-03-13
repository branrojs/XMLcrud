<?php
#leer documento xml
if (file_exists('C:\Users\admin\Dropbox\Examen\Matenimientos xml\JXML\xnlsrc\basededatosphp.xml')) { #vemos si el doc existe
    $xml = simplexml_load_file('C:\Users\admin\Dropbox\Examen\Matenimientos xml\JXML\xnlsrc\basededatosphp.xml'); #cargamos la clase simplexml junto a la direccion
} else {
    exit('Failed to open test.xml.');#mensaje si no existe :P
}
$persona = $xml->personas->addChild('persona'); #creamos el nodo
################# Elementos del nuevo nodo persona #################
$persona->addChild('nombre', 'mario');              
$persona->addChild('apellidos', 'calvo andres');
$persona->addChild('email', 'rodriguez@meneces');
$persona->addChild('direccion', 'morticia');
$persona->addChild('telefono', '498464569'); 
################# aca abajo guardamos el archivo###################
$xml->asXML('C:\Users\admin\Dropbox\Examen\Matenimientos xml\JXML\xnlsrc\basededatosphp.xml');
?>