let totalTicket = 2000;
let logs = [
  "woni request 09:12:29",
  "brown request 09:23:11",
  "brown leave 09:23:44",
  "jason request 09:33:51",
  "jun request 09:33:56",
  "cu request 09:34:02",
];

const solution = (totalTicket, logs) => {
  let list = logs.map((v) => {
    let temp = v.split(" ");
    return { name: temp[0], action: temp[1], time: temp[2].split(":") };
  });
  let result = [];
  let user = [];

  list.forEach((current_user) => {
    if (totalTicket > 0) {
      if (current_user.time[0] === "09") {
        if (current_user.action === "request") {
          if (result.length === 0) {
            result.push(current_user);
            user.push(current_user.name);
            totalTicket--;
          } else {
            let before_minute = Number(result[result.length - 1].time[1]);
            let before_second = Number(result[result.length - 1].time[2]);
            let current_minute = Number(current_user.time[1]);
            let current_second = Number(current_user.time[2]);

            if (current_minute - before_minute > 1) {
              if (!user.includes(current_user.name)) {
                result.push(current_user);
                user.push(current_user.name);
                totalTicket--;
              }
            } else if (current_minute - before_minute === 1) {
              if (current_second - before_second >= 0)
                if (!user.includes(current_user.name)) {
                  result.push(current_user);
                  user.push(current_user.name);
                  totalTicket--;
                }
            }
          }
        } else if (current_user.action === "leave") {
          result.pop();
          user.pop();
          totalTicket++;
        }
      }
    }
  });
  if (
    result[result.length - 1].time[1] === "59" &&
    result[result.length - 1].time[2] !== "00"
  ) {
    user.pop();
  }
  return user.sort((a, b) => (a > b ? 1 : -1));
};

console.log(solution(totalTicket, logs));
