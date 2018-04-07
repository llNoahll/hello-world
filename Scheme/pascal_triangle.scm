(define (pascal-iter line number)
  (cond ((or (= number 1) (= number line)) 1)
        (else (+
               (pascal-iter (- line 1) (- number 1))
               (pascal-iter (- line 1) number)))))
