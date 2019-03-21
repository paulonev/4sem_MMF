<?php 
//returns true if valid, false - otherwise
function isValidIP()
{
    $ips = file('forbiddenIPs.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES); // array of IP addresses
    
    $my_ip = $_SERVER['REMOTE_ADDR']; //localhost api address

    $response = true;
    foreach ($ips as $ipFromFile) {
        if(isIpMatching($ipFromFile, $my_ip)){
            //if IP is among forbidden IPs 
            $response = false;
        }
    }
    return $response;

}
//return true - if match, false - if mismatch
function isIpMatching($ipFromFile, $my_ip){
    //both are strings
    //44.55.666.777 to [44,55,666,777]
    $array_ipFromFile = explode(".",$ipFromFile);
    $array_myIp = explode(".",$my_ip);
    $match = true; //to find mismatches
    for($i=0;$i<count($array_myIp);$i++){
        if($array_ipFromFile[$i] != $array_myIp[$i]) $match = false;
    }
    return $match;
}

//method call
isValidIP();
?>