<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="lotto.css">
<link rel="stylesheet" href="animate.css" media="screen" title="no title" charset="utf-8">
</head>
<body>

<?php

$row = array();
$balls = range(1,35);

for($i = 1; $i <= 7; $i++) {
	shuffle($balls);
	$ball = array_pop($balls);
	array_push($row, $ball);
}

sort($row);
foreach ($row as $i) {
	echo '<div class="animated rollIn"><div class="ball">', $i, '</div></div>';
	}

#echo implode(', ',$row);

?>

<script src="wow.js" charset="utf-8"></script>
</body>
</html>
