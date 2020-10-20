from flask import Flask, request

from server.key import Key
from server.pool import Pool

app = Flask(__name__)
pool = Pool()
Key().setPool(pool)


@app.route('/')
def index():
    return "Yes, server is running"


@app.route('/keyPress', methods=['GET'])
def keyPress():
    if 'key' in request.args:
        pool.add("p " + request.args.get('key'))

    return "ok"


@app.route('/keyRelease', methods=['GET'])
def keyRelease():
    if 'key' in request.args:
        pool.add("r " + request.args.get('key'))

    return "ok"


def startServer(debug=True):
    app.run(host='0.0.0.0', debug=debug)
