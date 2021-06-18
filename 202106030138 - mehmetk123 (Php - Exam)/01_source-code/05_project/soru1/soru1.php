 <?php

function insertionSort(&$arr, $n)
{
    for ($i = 1; $i < $n; $i++)
    {
        $key = $arr[$i];
        $j = $i-1;

        while ($j >= 0 && $arr[$j] > $key)
        {
            $arr[$j + 1] = $arr[$j];
            $j = $j - 1;
        }
         
        $arr[$j + 1] = $key;
		echo printArray($arr,$n);
    }
}

function quick_sort($my_array)
 {
	$loe = $gt = array();
	if(count($my_array) < 2)
	{
		return $my_array;
	}
	$pivot_key = key($my_array);
	$pivot = array_shift($my_array);
	foreach($my_array as $val)
	{
		if($val <= $pivot)
		{
			$loe[] = $val;
		}elseif ($val > $pivot)
		{
			$gt[] = $val;
		}
	}
	echo printArray($my_array,sizeof($my_array));
	return array_merge(quick_sort($loe),array($pivot_key=>$pivot),quick_sort($gt));
}
 

function printArray(&$arr, $n)
{
    for ($i = 0; $i < $n; $i++)
        echo $arr[$i].",";
    echo "\n";
}
 
$arr = array(71,55,65,85,75,60,90);

echo "a) insertion sort >> \n\n";
insertionSort($arr, sizeof($arr));
echo "\n >>>> ";
printArray($arr, sizeof($arr));

$arr = array(71,55,65,85,75,60,90);
echo "\n\nb) >> quik sort >> \n\n";
$arr = quick_sort($arr);
echo "\n >>>> ";
printArray($arr, sizeof($arr));

?>