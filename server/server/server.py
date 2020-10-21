"""Main server to listen to key press and release"""

from flask import Flask, request

from server.key import Key
from server.pool import Pool

# creating the Pool and setting it to Key class
app = Flask(__name__)
pool = Pool()
Key().setPool(pool)


@app.route('/')
def index():
    return "Yes, server is running"


@app.route('/keyPress', methods=['GET'])
def keyPress():
    """Adding the key press action for {key}"""
    if 'key' in request.args:
        pool.add("p " + request.args.get('key'))

    return "ok"


@app.route('/keyRelease', methods=['GET'])
def keyRelease():
    """Adding the key release action for {key}"""
    if 'key' in request.args:
        pool.add("r " + request.args.get('key'))

    return "ok"


def startServer(debug=True):
    """Starting the server"""
    app.run(host='0.0.0.0', debug=debug)
