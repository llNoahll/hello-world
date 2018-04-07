(define (practice a b c)
  (+
   (square (if (> a b) a b))
   (square (if (> a c) a c))
   ))

(define (square x) (* x x))
(define (abs x)
  (if (< x 0) (- x) x))
(define (average x y)
  (/ (+ x y)
     2))

(define (sqrt x)
  (define (improve guess)
    (average guess (/ x guess))
    )
  (define (good-enough? new-guess old-guess)
    (> 1e-4
       (abs (- (/ new-guess old-guess) 1))))

  (define (sqrt-iter guess)
    (if (good-enough? (improve guess) guess)
        guess
        (sqrt-iter (improve guess))
        ))
  (sqrt-iter 1))

(sqrt 4)
