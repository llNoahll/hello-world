(load "sqrt.scm")

(define (cube-root x)
  (define (good-enough? old-guess new-guess)
    (> 1e-4 (abs (- 1 (/ old-guess new-guess))))
    )
  (define (improve guess)
    (/
     (+
      (/ x (square guess))
      (* 2 guess))
     3))
  (define (cube-root-iter guess)
    (if (good-enough? guess (improve guess))
        guess
        (cube-root-iter (improve guess) x)))
  (cube-root-iter 1))

(cube-root 8)
