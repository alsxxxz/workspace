// 02_basic/10_logical.js
console.log(4 || undefined);
console.log(undefined || 4);

console.log(4 && undefined);
console.log(undefined && 4);

// 노드 환경이라 global을 사용함. 브라우저에서는 window를 사용
global.superConsole = {
  log: function (...args) {
    const time = new Date().toLocaleTimeString();
    console.log(`[${time}]`, ...args);
  },
};

const myConsole = global.superConsole || global.console;

myConsole.log("Hello MyConsole");
