(define (fibonacci x)
  (define (fibonacci-iter a b n)          ; n as the iterative times
    (if (= n 0)
        a
        (fibonacci-iter b (+ a b) (- n 1))))
    (fibonacci-iter 0 1 x))

(fibonacci 6)
