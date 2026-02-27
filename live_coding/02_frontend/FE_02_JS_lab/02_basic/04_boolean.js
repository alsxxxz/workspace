//02_basic/04_boolean.js
const bools = [true, false, null, undefined, NaN, 0, "", "string", [], {}];
bools.forEach((value) => {
  if (value) {
    console.log(`${value} is true`);
  } else {
    console.log(`${value} is false`);
  }
});
