var date = [];
var total_user = [];
$.getJSON("tables/data3.json",function(json){
	console.log(json);
	
	$.each(json,function(index,field){
		$.each(field,function(id2,field2){
			if(id2 === "date"){
				console.log("is date");
				date.push(field2);
			}else if(id2 === "total_user"){
				console.log("is total_user");
				total_user.push(field2);
			}
		});
	});
	console.log(date.length);

});


var lineChartData = {
	labels : date,
	datasets : [
		{
			label: "My First dataset",
			fillColor : "rgba(220,220,220,0.2)",
			strokeColor : "rgba(220,220,220,1)",
			pointColor : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(220,220,220,1)",
			data : total_user
		}
		// ,
		// {
		// 	label: "My Second dataset",
		// 	fillColor : "rgba(48, 164, 255, 0.2)",
		// 	strokeColor : "rgba(48, 164, 255, 1)",
		// 	pointColor : "rgba(48, 164, 255, 1)",
		// 	pointStrokeColor : "#fff",
		// 	pointHighlightFill : "#fff",
		// 	pointHighlightStroke : "rgba(48, 164, 255, 1)",
		// 	data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
		// }
	]

}

var lineChartData2 = {
	labels : date,
	datasets : [
		{
			label: "My First dataset",
			fillColor : "rgba(220,220,220,0.2)",
			strokeColor : "rgba(220,220,220,1)",
			pointColor : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			pointHighlightStroke : "rgba(220,220,220,1)",
			data : total_user
		}
	]
}

var barChartData = {
	labels : date,
	datasets : [
		{
			fillColor : "rgba(220,220,220,0.5)",
			strokeColor : "rgba(220,220,220,0.😎",
			highlightFill: "rgba(220,220,220,0.75)",
			highlightStroke: "rgba(220,220,220,1)",
			data : total_user
		}
		// ,
		// {
		// 	fillColor : "rgba(48, 164, 255, 0.2)",
		// 	strokeColor : "rgba(48, 164, 255, 0.😎",
		// 	highlightFill : "rgba(48, 164, 255, 0.75)",
		// 	highlightStroke : "rgba(48, 164, 255, 1)",
		// 	data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
		// }
	]

}

var pieData = [
	{
		value: 300,
		color:"#30a5ff",
		highlight: "#62b9fb",
		label: "Blue"
	},
	{
		value: 50,
		color: "#ffb53e",
		highlight: "#fac878",
		label: "Orange"
	},
	{
		value: 100,
		color: "#1ebfae",
		highlight: "#3cdfce",
		label: "Teal"
	},
	{
		value: 120,
		color: "#f9243f",
		highlight: "#f6495f",
		label: "Red"
	},
	{
		value: 130,
		color: "#ffa0ad",
		highlight: "#ffa0ad",
		label: "Pink"
	}
];

var doughnutData1 = [
	{
		value: 250,
		color:"#30a5ff",
		highlight: "#62b9fb",
		label: "Bus stop1"
	},
	{
		value: 50,
		color: "#ffb53e",
		highlight: "#fac878",
		label: "Bus stop2"
	},
	{
		value: 100,
		color: "#1ebfae",
		highlight: "#3cdfce",
		label: "Bus stop3"
	},
	{
		value: 120,
		color: "#f9243f",
		highlight: "#f6495f",
		label: "Bus stop4"
	},
	{
		value: 130,
		color: "#ffa0ad",
		highlight: "#ffa0ad",
		label: "Bus stop5"
	}

];

var doughnutData2 = [
	{
		value: 300,
		color:"#30a5ff",
		highlight: "#62b9fb",
		label: "Bus 1"
	},
	{
		value: 50,
		color: "#ffb53e",
		highlight: "#fac878",
		label: "Bus 2"
	},
	{
		value: 100,
		color: "#1ebfae",
		highlight: "#3cdfce",
		label: "Bus 3"
	},
	{
		value: 120,
		color: "#f9243f",
		highlight: "#f6495f",
		label: "Bus 4"
	},
	{
		value: 130,
		color: "#ffa0ad",
		highlight: "#ffa0ad",
		label: "Bus 5"
	}

];


	window.onload = function(){
		window.setTimeout(function(){
			var chart1 = document.getElementById("line-chart").getContext("2d");
			window.myLine = new Chart(chart1).Line(lineChartData, {
				responsive: true
			});
			var chart2 = document.getElementById("bar-chart").getContext("2d");
			window.myBar = new Chart(chart2).Bar(barChartData, {
				responsive : true
			});
			var chart3 = document.getElementById("doughnut-chart1").getContext("2d");
			window.myDoughnut = new Chart(chart3).Doughnut(doughnutData1, {responsive : true
			});
			var chart5 = document.getElementById("doughnut-chart3").getContext("2d");
			window.myDoughnut = new Chart(chart5).Doughnut(doughnutData2, {responsive : true
			});
			var chart4 = document.getElementById("pie-chart").getContext("2d");
			window.myPie = new Chart(chart4).Pie(pieData, {responsive : true
			});
		},1000);
	};


