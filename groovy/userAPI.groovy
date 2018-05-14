def call(body)
{
   def config = [:]
   body.resolverStrategy = Closure.DELEGATE_FIRST
   body.delegate = config
   body()
   def json = ''{"userID" : ${config.userID},"title" : ${config.title} ,"body" : ${config.body}}''
   println json
   // URL = 'https://jsonplaceholder.typicode.com/posts'
   //sh "curl -o /dev/null -s -X POST '+URL+' -H 'X-Api-Key:[redacted]' -H 'Content-Type: application/json' d '${object}'"
}
