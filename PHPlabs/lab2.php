<!DOCTYPE html>
<html>
<head>
	<title>Geron's calculation of square of triangle</title>
</head>
<body>
	<p>
		Вариант 2.13 Напишите функцию  S = sqrt(p(p-a)(p-b)(p-c)), вычисляющую площадь треугольника.
	</p>
<?php 
$a = rand(1,10);
$b = rand(1,10);
$c = rand(1,10);

if(triangleExists($a,$b,$c)){
	echo "The square of triangle = ";
	printf("%.03f", geronsFormula($a,$b,$c));
}
else echo "Oops...Triangle with that sides doesn't exist";

function triangleExists($a, $b, $c){
	//check whether sum of any two sides is less than the third side
	return (($a + $b > $c) AND ($b + $c > $a) AND ($a + $c > $b));
}

function geronsFormula($a,$b,$c){
	$p = ($a+$b+$c)/2;
	return sqrt($p*($p-$a)*($p-$b)*($p-$c));
}

?>
</body>
</html> 