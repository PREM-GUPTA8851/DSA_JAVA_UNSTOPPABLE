/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    // js m object key: value pairs m hote h 
    // object return krna h hume
    // return {toBe: fn{}, notToBe: fn()};
    return {
        toBe: function(another){
            if(another === val) return true;
            throw new Error("Not Equal");
        },
        notToBe: function(another){
            if(another !== val) return true;
            throw new Error("Equal");
        }
    };
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */