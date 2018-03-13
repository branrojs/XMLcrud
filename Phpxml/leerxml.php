<?php
############## LEER EL ARCHIVO XML#########
######COMRPOBAMOS -- CARGAMOS SIMPLEXML CON EL DIR DEL ARCHIVO
if (file_exists('C:\Users\admin\Dropbox\Examen\Matenimientos xml\JXML\xnlsrc\basededatosphp.xml')) {
    $xml = simplexml_load_file('C:\Users\admin\Dropbox\Examen\Matenimientos xml\JXML\xnlsrc\basededatosphp.xml');
} else {
    exit('Failed to open test.xml.');
}
######muestra LOS ELEMENTOS del archivo :D es el "PrettyPrint" 
foreach ($xml->xpath('//persona') as $xml) {
    echo $xml->nombre, ' de apellidos: ', $xml->apellidos, '<br>', PHP_EOL;
    echo $xml->email, '<br>', PHP_EOL;;
    echo $xml->direccion, '<br>', PHP_EOL;;
    echo $xml->telefono, '<br>', '<br>', PHP_EOL;;
}


?>