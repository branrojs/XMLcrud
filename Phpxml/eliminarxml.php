<?php
##########ELIMINAR NODO DE XML#############

if (file_exists('C:\Users\admin\Dropbox\Examen\Matenimientos xml\JXML\xnlsrc\basededatosphp.xml')) {#vemos si el doc existe
    $xml = new DOMdocument(); #cargamos la clase DOMDocument 
    $xml->load('C:\Users\admin\Dropbox\Examen\Matenimientos xml\JXML\xnlsrc\basededatosphp.xml');# cargamos el archivo XML DOM junto a la direccion
} else {
    exit('No existe el archivo.');
}
####QUERY PARA ENCONTRAR EL NODO :P############
$xpath = new DOMXPath($xml);
###########################SI SE LLEGARA A QUERER ELIMINAR 1 ELEMENTO ES SIMPLE, 
############################ SE CAMBIA LO SIGUIENTE: persona/nombre[. = "Mr. Parser"] 
########################### lo interpreta como si buscaramos ese nodo y no el anterior a ese
foreach($xpath->query('//personas/persona[. /nombre= "Adecio"]') as $record) {
#################con esta linea de aca ^ buscamos en ese nodo, el elemento que se contenga el texto que busquemos :P
    $record->parentNode->removeChild($record); #eliminamos magicamente 
}

#foreach($xpath->query('//personas/persona/nombre[. = "Adecio"]') as $record) {
#################con esta linea de aca ^ buscamos en ese nodo, el elemento que se contenga el texto que busquemos :P;
 #   $record->parentNode->replaceChild(record,"nombre=Alberto"); 
#}


echo $xml->save('C:\Users\admin\Dropbox\Examen\Matenimientos xml\JXML\xnlsrc\basededatosphp.xml');#guardamos el archivo
?>