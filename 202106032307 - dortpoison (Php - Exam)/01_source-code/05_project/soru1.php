 <?php

function QuickSort($dizi)
 {
	$loe = $gt = array();
	if(count($dizi) < 2)
	{
		return $dizi;
	}
	$pivot_key = key($dizi);
	$pivot = array_shift($dizi);
	foreach($dizi as $val)
	{
		if($val <= $pivot)
		{
			$loe[] = $val;
		}elseif ($val > $pivot)
		{
			$gt[] = $val;
		}
	}
	echo $pivot." >> ";
	for ($j = 0; $j < sizeof($dizi); $j++)
		echo $dizi[$j]." ";
	echo "\n";
	return array_merge(QuickSort($loe),array($pivot_key=>$pivot),QuickSort($gt));
}
 

$dizi = array(71,55,65,85,75,60,90);

echo "kisim 1 (insertion-sort): \n\n";

$boyut = sizeof($dizi);

for ($i = 1; $i < $boyut; $i++)
{
	
	$anahtar = $dizi[$i];
	$j = $i-1;

	while ($j >= 0 && $dizi[$j] > $anahtar)
	{
		$dizi[$j + 1] = $dizi[$j];
		$j = $j - 1;
	}
	 
	$dizi[$j + 1] = $anahtar;
	
	echo $i." >> ";
	for ($j = 0; $j < $boyut; $j++)
		echo $dizi[$j]." ";
	echo "\n";
}
echo "Sonuc >> ";
for ($j = 0; $j < $boyut; $j++)
	echo $dizi[$j]." ";
echo "\n";


$dizi = array(71,55,65,85,75,60,90);
echo "\n\nkisim 2 (quick-sort): \n\n";

QuickSort($dizi);
echo "Sonuc >> ";
for ($j = 0; $j < $boyut; $j++)
	echo $dizi[$j]." ";
echo "\n";

?>