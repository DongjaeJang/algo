const solution = (bridge_length, weight, truck_weights) => {
  let tw = truck_weights.slice();
  let onBridge = [{ weight: tw.shift(), distance: 1 }];
  let finish = [];
  let second = 1;
  while (true) {
    if (onBridge[0].distance > bridge_length) {
      let finishTruck = onBridge.shift();
      finish.push(finishTruck);
    }
    if (finish.length === truck_weights.length) break;
    let onBridgeWeight = 0;
    onBridge.forEach((truck) => {
      onBridgeWeight += truck.weight;
    });
    let currentTruck = tw[0];

    if (onBridgeWeight + currentTruck <= weight) {
      currentTruck = tw.shift();
      onBridge.push({ weight: currentTruck, distance: 1 });
    }
    onBridge.forEach((truck) => {
      return (truck.distance += 1);
    });
    second += 1;
  }

  return second;
};

console.log(solution(2, 10, [7, 4, 5, 6]));
